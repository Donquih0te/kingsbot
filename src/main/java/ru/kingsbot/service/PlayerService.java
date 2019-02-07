package ru.kingsbot.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j2;
import ru.kingsbot.api.ApiRequest;
import ru.kingsbot.api.keyboard.Keyboard;
import ru.kingsbot.entity.Player;
import ru.kingsbot.entity.clan.Clan;
import ru.kingsbot.repository.PlayerRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Log4j2
public class PlayerService {

    private static final Random RANDOM = new Random();

    private final PlayerRepository repository = new PlayerRepository();
    private final RequestHandler requestHandler;
    private final Gson gson;
    private JsonParser parser;

    public PlayerService(Gson gson, RequestHandler requestHandler) {
        this.gson = gson;
        this.requestHandler = requestHandler;
        parser = new JsonParser();
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
                .param("random_id", RANDOM.nextInt(999_999))
                .param("peer_id", peerId)
                .param("message", message);

        if(keyboard != null) {
            builder.param("keyboard", gson.toJson(keyboard));
        }
        requestHandler.sendVkApiRequest(builder.build());
    }

    public void validateName(Player player) {
        if(player.getId() < 0) {
            return;
        }
        ApiRequest request = ApiRequest.newApiRequest()
                .method("users.get")
                .param("user_ids", player.getId())
                .build();

        String result = requestHandler.sendVkApiRequest(request);

        JsonObject json = parser.parse(result).getAsJsonObject();
        if(!json.has("response")) {
            log.error("Impossible to set player name\n" + result);
            return;
        }
        JsonArray response = json.get("response").getAsJsonArray();
        JsonObject item = response.get(0).getAsJsonObject();
        player.setFirstName(item.get("first_name").getAsString());
        player.setLastName(item.get("last_name").getAsString());
    }

}
