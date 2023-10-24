package ru.naumen.collection.task1;

import ru.naumen.collection.task2.Ticket;

import java.util.*;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно написать утилитный метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 *
 * См. {@link User}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task1 {

    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     * <p>Пусть коллекция collA имеет N объектов, collB - M объектов.</p>
     * <p>Преобразование коллекции collA в множество имеет сложность O(N)</p>
     * <p>Итерирование по коллекции collB имеет сложность O(M)</p>
     * <p>Операция contains() по множеству collASet имеет сложность O(1), как объект хранится в виде хеша</p><br/>
     * <p>Итогования сложность: O(N + M)</p>
     *
     * @since 24.10.2023
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        Set<User> collASet = new HashSet<>(collA);
        List<User> duplicated = new ArrayList<>();
        for (User user: collB)
            if (collASet.contains(user))
                duplicated.add(user);
        return duplicated;
    }
}
