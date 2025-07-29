package com.order.Utils;

public class RegexPattern {

    public static final String USER_ID = "^auth0\\|[a-f0-9]{24}$";

    public static final String ROLE_ID = "rol_[a-zA-Z0-9]{15,17}";

    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z]).{8,}$";

    public static final String UPPERCASE_UNDERSCORE = "^[A-Z0-9]+(?:_[A-Z0-9]+)*$";

    public static final String TEN_DIGITS = "\\d{10}";

    public static final String FIVE_DIGITS = "\\d{5}";

    public static final String LIST_OF_DIGITS = "^\\d+(?:,\\d+)*$";

    public static final String PROVIDER_SUFFIX = "^[a-zA-Z., ]+$";

    public static final String ONLY_LETTERS = "^[a-zA-Z]+$";

    public static final String CAMEL_CASE = "^[a-z]+(?:[A-Z][a-z]*)+$";

    public static final String NO_WHITESPACE = "^[^\\s]+$";

    public static final String ONLY_LETTERS_WITH_WHITESPACES = "^[a-zA-Z ]+$";

    public static final String SSN = "^\\d{3}-\\d{2}-\\d{4}$";

    public static final String NAME = "^[a-zA-Z., ]+$";

    public static final String NO_SPECIAL_CHARACTERS = "^[a-zA-Z0-9 ]+$";

    public static final String RGB_HEX_CODE = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

    public static final String UPPERCASE_WITH_WHITESPACE = "^[A-Z0-9 ]+$";
}
