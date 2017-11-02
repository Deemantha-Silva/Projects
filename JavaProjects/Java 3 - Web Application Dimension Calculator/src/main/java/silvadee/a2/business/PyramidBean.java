/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silvadee.a2.business;

import static java.lang.Math.PI;

/**
 *
 * @author Deemantha
 */
public class PyramidBean {

    private int baseN;
    private double baseSide;
    private double height;
    private double baseArea;
    private double volume;
    private String pyramidName;

    public PyramidBean() {
    }

    public String getBaseN() {
        return Integer.toString(baseN);
    }

    public void setBaseN(String baseN) {
        this.baseN = Integer.parseInt(baseN);
    }

    public String getBaseSide() {
        return Double.toString(baseSide);
    }

    public void setBaseSide(String baseSide) {
        this.baseSide = Double.parseDouble(baseSide);
    }

    public String getHeight() {
        return Double.toString(height);
    }

    public void setHeight(String height) {
        this.height = Double.parseDouble(height);
    }

    public String getBaseArea() {

        double valTangent = 4 * Math.tan(Math.PI / this.baseN);
        double baseSideSquared = this.baseN * (this.baseSide * this.baseSide);
        this.baseArea = baseSideSquared / valTangent;
        return Double.toString(baseArea);
    }

    public String getVolume() {
        this.volume = (this.baseArea * this.height) / 3;
        return Double.toString(volume);
    }

    public String getPyramidName() {

        String[] pNames = {"Triangular", "Square", "Pentagonal", "Hexagonal", "Heptagonal", "Octagonal", "Nonagonal",
            "Decagonal", "Hendecagonal", "Dodecagonal", "Tridecagonal", "Tetradecagonal", "Pentadecagonal",
            "Hexadecagonal", "Heptadecagonal", "Octadecagonal", "Enneadecagonal", "Icosagonal"};

        return this.pyramidName = pNames[this.baseN - 3] + "-Based Pyramid";
    }

}
