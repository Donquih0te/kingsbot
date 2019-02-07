package ru.kingsbot.service;

import ru.kingsbot.entity.conversation.Conversation;
import ru.kingsbot.repository.ConversationRepository;

public class ConversationService {

    private ConversationRepository conversationRepository = new ConversationRepository();

    public Conversation getBuId(Long id) {
        return conversationRepository.get(id);
    }

    public void save(Conversation conversation) {
        conversationRepository.save(conversation);
    }

}
