package aritmeticastokens;

// aqui se encuentran las expresiones regulares y el token que generan
public enum Tipo {
    PR("int$|float$|double$|do$|while$"),
    CE("^[-]?(\\d)+$"),
    CF("^[-]?(\\d)+(.(\\d)+)$"),
    OA("^[+-/*]$"),
    OR("([<>][=]?)$|([!=][=])$"),
    OB("([&][&])$|([|][|])$"),
    IDE("^[A-Za-z_$][\\w$]*$"),
    OAS("^[=]$"),
    EXT1("[(]$"),
    EXT2("[)]$"),
    SAL1("[{]$"),
    SAL2("[}]$"),
    DEL("^[;]$");

    public final String patron;

    Tipo(String s) {
        this.patron = s;

    }
}
