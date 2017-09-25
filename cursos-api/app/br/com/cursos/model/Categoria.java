package br.com.cursos.model;

public enum Categoria {

    MOBILE("Mobile"),
    FRONTEND("Frontend"),
    BACKEND("Backend"),
    DEVOPS("Devops"),
    UX("UX");

    private final String label;

    Categoria(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
