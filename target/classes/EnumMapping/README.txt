JPA provide 2 ways to map enums.You can either use its String representation or its ordinal value.

Using the @Enumerated annotation, you can use EnumType.ORDINAL or EnumType.STRING to map the enum value to its
database representation.The ordinal of an Enum depends on the ordering of its values and can create problems, if
we need to add new ones.

The String representation is verbose, and the renaming of an enum value will break the database mapping.

The ordinal of an enum value is its position in the enum declaration.This value changes which requires you
to update your database when you remove an existing value or don't add new values to the end of the Enum declaration.

You can define a custom mapping and avoid these issues with an AttributeConverter.