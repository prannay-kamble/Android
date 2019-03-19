package com.gl.app.Iservice.service;

import com.gl.app.Iservice.IScintificCalculater;


public class ScintificCalculaterImpl implements IScintificCalculater {
    @Override
    public double log(double number) {

        return Math.log(number);
    }

    @Override
    public double logn(double number) {
        return Math.log10(number);
    }
}
