package ru.kingsbot.service;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;
import ru.kingsbot.client.ApiRequest;
import ru.kingsbot.client.TransportClient;
import ru.kingsbot.client.exception.InvalidResponseException;
import ru.kingsbot.client.objects.VkError;
import ru.kingsbot.client.objects.users.User;
import ru.kingsbot.command.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.repository.PlayerRepository;
import ru.kingsbot.utils.JsonUtil;
import ru.kingsbot.utils.Utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
public class PlayerService {

    private final PlayerRepository repository = new PlayerRepository();
    private final TransportClient transportClient;

    public PlayerService(TransportClient transportClient) {
        this.transportClient = transportClient;
    }

    public void savePlayer(Player player) {
        repository.save(player);
    }

    public Player load(Integer id) {
        return repository.load(id);
    }

    public void update(Player player) {
        repository.update(player);
    }

    public Player getById(Integer id) {
        return repository.get(id);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public void delete(Player player) {
        repository.delete(player.getId());
    }

    public List<Player> getEnemyToAttack(Player player) {
        return repository.getEnemyToPlayerByCancelledShieldAndTerritory(player);
    }

    public List<Player> getPlayersTop() {
        return repository.getPlayersOrderByTerritory();
    }

    public List<Clan> getClansRating() {
        return repository.getClansOrderByRating();
    }

    public void sendMessage(Integer peerId, String message, Keyboard keyboard) {
        sendMessage(List.of(peerId), message, keyboard);
    }

    public void sendMessage(Player player, String message, Keyboard keyboard) {
        sendMessage(List.of(player.getId()), message, keyboard);
    }

    public void sendMessage(List<Integer> peerIds, String message, Keyboard keyboard) {
        String peerId = peerIds.stream().map(Object::toString).collect(Collectors.joining(","));
        ApiRequest.Builder builder = ApiRequest.newApiRequest()
                .method("messages.send")
                .param("random_id", Utils.RANDOM.nextInt(Integer.MAX_VALUE))
                .param("peer_id", peerId)
                .param("message", message);

        if(keyboard != null) {
            builder.param("keyboard", keyboard.toString());
        }
        transportClient.sendVkApiRequest(builder.build());
    }


    public void validateName(Player player) throws InvalidResponseException {
        ApiRequest request = ApiRequest.newApiRequest()
                .method("users.get")
                .param("user_ids", player.getId())
                .build();

        String result = transportClient.sendVkApiRequest(request);

        JsonObject json = JsonUtil.PARSER.parse(result).getAsJsonObject();
        if(!json.has("response")) {
            VkError error = JsonUtil.GSON.fromJson(json.get("error"), VkError.class);
            throw new InvalidResponseException(error);
        }

        List<User> response = JsonUtil.GSON.fromJson(json.get("response"), new TypeToken<List<User>>(){}.getType());
        Optional<User> first = response.stream().filter(user -> (user.getId().compareTo(player.getId()) == 0)).findFirst();

        first.ifPresent(user -> {
            player.setFirstName(user.getFirstName());
            player.setLastName(user.getLastName());
        });

    }

}
