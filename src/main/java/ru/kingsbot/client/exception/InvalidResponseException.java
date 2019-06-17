package ru.kingsbot.client.exception;

import lombok.Getter;
import ru.kingsbot.client.objects.VkError;

public class InvalidResponseException extends Exception {

    @Getter
    private VkError vkError;

    public InvalidResponseException() {
        super();
    }

    public InvalidResponseException(VkError vkError) {
        this.vkError = vkError;
    }

}
