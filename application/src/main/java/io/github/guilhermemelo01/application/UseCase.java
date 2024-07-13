package io.github.guilhermemelo01.application;

public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN anIn);
}