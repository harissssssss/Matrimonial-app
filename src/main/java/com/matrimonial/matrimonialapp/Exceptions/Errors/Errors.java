package com.matrimonial.matrimonialapp.Exceptions.Errors;

public enum Errors implements ErrorStatusType {
    ID_NOT_FOUND(01, "Profile id not found");

    private final int code;
    private final String description;

    Errors(int code, String description) {
        this.code = code;
        this.description = description;
    }


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

