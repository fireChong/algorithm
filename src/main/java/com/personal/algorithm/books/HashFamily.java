package com.personal.algorithm.books;

public interface HashFamily<AnyType> {
    int hash(AnyType x, int which);

    int getNumberOfFunctions();

    void generateNewFunctions();
}
