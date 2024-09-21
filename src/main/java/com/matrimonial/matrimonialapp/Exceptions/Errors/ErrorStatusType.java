package com.matrimonial.matrimonialapp.Exceptions.Errors;

import java.io.Serializable;

public interface ErrorStatusType extends Serializable {

    int getCode();

    String getDescription();
}
