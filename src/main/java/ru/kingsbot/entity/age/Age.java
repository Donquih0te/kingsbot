package ru.kingsbot.entity.age;

public enum Age {

    PREHISTORIC("Первобытность"),
    STONE("Каменный век"),
    COPPER("Медный век"),
    BRONZE("Бронзовый век"),
    DARK("Темные века"),
    MIDDLE("Средневековье"),
    RENAISSANCE("Возрождения"),
    IMPERIAL("Империй"),
    INDUSTRIAL("Индустриальный век"),
    WORLD_WAR_1("Первая мировая война"),
    WORLD_WAR_2("Вторая мировая война"),
    MODERN("Современность"),
    DIGITAL("Век информации"),
    NANO("Век нанотехнологий");

    private String name;

    private Age(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
