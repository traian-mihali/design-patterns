package com.designpatterns.strategy;

public class ImageStorage {
    public void store(String filename, Compressor compressor, Filter filter){
        compressor.compress(filename);
        filter.apply(filename);
    }
}
