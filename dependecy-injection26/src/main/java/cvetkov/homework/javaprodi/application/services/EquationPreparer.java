package cvetkov.homework.javaprodi.application.services;


import cvetkov.homework.javaprodi.application.model.Equation;

import java.util.List;

public interface EquationPreparer {
    List<Equation> prepareEquationsFor(int base);
}
