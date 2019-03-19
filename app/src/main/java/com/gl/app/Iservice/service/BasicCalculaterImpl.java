package com.gl.app.Iservice.service;

import com.gl.app.Iservice.IBasicCalculater;

public class BasicCalculaterImpl implements IBasicCalculater {
    public BasicCalculaterImpl() {
        super();
    }

    @Override
    public Double add(double first, double second) {
        return (first + second);
    }

    @Override
    public Double substraction(double first, double second) {
        return (first - second);
    }

    @Override
    public Double multipication(double first, double second) {

        return (first * second);
    }

    @Override
    public Double divsion(double first, double second) {
        return (first / second);
    }
}
