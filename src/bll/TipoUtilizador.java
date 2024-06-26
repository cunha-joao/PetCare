package bll;

public enum TipoUtilizador {
    ADMINISTRADOR,
    VETERINARIO,
    EDUCADOR,
    AUXILIAR,
    SECRETARIADO,
    CLIENTE,
    PRESTADOR;

    public static TipoUtilizador fromString(String text) {
        for (TipoUtilizador b : TipoUtilizador.values()) {
            if (b.name().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
