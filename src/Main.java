import model.UserDB;
import model.UserDTO;

import java.util.*;

/**
 * <p>Популярні завдання для закріплення теорії з тем про функціональне програмування, функціональні інтерфейси
 * та Stream API. 10 задач, які містять практичне застосування всіх важливих методів з інтерфейсу Stream.</p>
 * <p>Початкова реалізація задач відповідно до типу повертає мого значення повертає null, 0d або false.</p>
 * <p>Успішним результатом виконання завдання є проходження всіх тестів з класу StreamTaskTest.</p>
 */
public class Main {
    /**
     * Перетворення об'єкта одного типу даних в інший. Існує модель, що містить усю інформацію про користувача,
     * яка лежить в базі даних, а є модель, яку потрібно передати на клієнтську частину - без пароля та email-у.
     *
     * @param users колекція користувачів з БД.
     * @return колекція моделей користувачів для клієнта.
     */
    public static List<UserDTO> userDBToUserDTO(final List<UserDB> users) {
        return null;
    }

    /**
     * Знайти всіх користувачів за вказаним роком народження.
     *
     * @param users колекція користувачів з БД.
     * @param year  рік народження.
     * @return колекція користувачів, що відповідає умові.
     */
    public static List<UserDB> findUsersByYear(final List<UserDB> users, final int year) {
        return null;
    }

    /**
     * Знайти середнє арифметичне значення віку користувачів.
     *
     * @param users колекція користувачів з БД.
     * @return середнє арифметичне віку або -1, якщо колекція пуста.
     */
    public static double getAverageUsersAge(final List<UserDB> users) {
        return 0;
    }

    /**
     * Кластеризувати користувачів за країною.
     *
     * @param users колекція користувачів з БД.
     * @return хеш-таблиця, ключ якої - країна, а значення - список користувачів з відповідної країни.
     */
    public static Map<String, List<UserDB>> groupUsersByCountry(final List<UserDB> users) {
        return null;
    }

    /**
     * Сортувати користувачів за прізвищем та повернути перших трьох.
     *
     * @param users колекція користувачів з БД.
     * @return відсортовані п'ять користувачів у списку.
     */
    public static List<UserDB> sortByLastNameAndReturnFirstThree(final List<UserDB> users) {
        return null;
    }

    /**
     * Групувати прізвища користувачів за роком народження та відсортувати прізвища у множинах.
     *
     * @param users колекція користувачів з БД.
     * @return хеш-таблиця, ключ якої - рік, а значення - відсортовані прізвища.
     */
    public static Map<Integer, Set<String>> groupSortedLastNamesByYear(final List<UserDB> users) {
        return null;
    }

    /**
     * Сортувати користувачів за ім'ям та за прізвищем.
     *
     * @param users колекція користувачів з БД.
     * @return колекція відсортованих користувачів.
     */
    public static List<UserDB> sortByFirstNameAndLastName(final List<UserDB> users) {
        return null;
    }

    /**
     * Перевірити чи існує користувач з відповідною адресою електронної поштової скриньки.
     *
     * @param users колекція користувачів з БД.
     * @param email ел. адреса користувача.
     * @return true - якщо такий користувач наявний, false - інакше.
     */
    public static boolean isUserWithEmailExists(final List<UserDB> users, final String email) {
        return false;
    }

    /**
     * <p>Повернути список-сторінку. Вона має містити кількість записів відповідно pageSize та вказувати ті записи,
     * які належать сторінці номер (індекс з 0) page.</p>
     * <p>Наприклад, якщо в базі даних 10 користувачів, а вхідні аргументи page = 0, pageSize = 5, то мають бути видані
     * перші 5 користувачів (з індексу 0 до 4 включно).</p>
     * <p>Якщо вхідні аргументи page = 2, pageSize = 2, то мають бути видані користувачі за індексом 4 та 5. Перша (0)
     * сторінка містить користувачів за індексом 0, 1, а друга (1) сторінка - користувачів за індексом 2 і 3.</p>
     * <p><b>Формула skip = page * pageSize, limit = pageSize.</b></p>
     *
     * @param users    колекція користувачів з БД.
     * @param page     номер сторінки.
     * @param pageSize розмір сторінки.
     * @return визначена кількість елементів визначеної сторінки.
     */
    public static List<UserDB> returnPageWithSize(final List<UserDB> users, final int page, final int pageSize) {
        return null;
    }

    /**
     * Кількість згадувань кожного символу (кожної літери) в усіх прізвищах користувачів.
     *
     * @param users колекція користувачів з БД.
     * @return хеш-таблиця, ключ якої - символ (літера), а значення - її кількість в усіх прізвищах.
     */
    public static Map<Character, Long> getCharsFrequencyFromLastName(final List<UserDB> users) {
        return null;
    }
}
