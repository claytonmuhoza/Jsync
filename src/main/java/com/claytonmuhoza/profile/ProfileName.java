package com.claytonmuhoza.profile;

public class ProfileName {
    private String name;

    public ProfileName(String name) {
        if (!name.matches("^[a-zA-Z][a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException(
                    "Le nom du profile doit contenir au moins deux caractères, commencer par une lettre, et ne contenir que des lettres et des chiffres (aucun caractère spécial)."
            );
        }
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
