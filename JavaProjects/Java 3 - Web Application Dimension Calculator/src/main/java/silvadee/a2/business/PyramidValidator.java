/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silvadee.a2.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deemantha
 */
public class PyramidValidator {

    private String errorsBase;
    private String errorsSides;
    private String errorsHeight;
    public int errorsCount;

    private String bases;
    private String sides;
    private String heights;

    public PyramidValidator(String bases, String sides, String heights) {
        this.bases = bases;
        this.sides = sides;
        this.heights = heights;
        validateBases();
        validateSides();
        validateHeights();
    }

    public String getBases() {
        return bases;
    }

    public String getSides() {
        return sides;
    }

    public String getHeights() {
        return heights;
    }

    public String getErrorsBase() {
        return errorsBase;
    }

    public String getErrorsSides() {
        return errorsSides;
    }

    public String getErrorsHeight() {
        return errorsHeight;
    }

    private void validateBases() {
        String pattern = "[0-9]*";
        
        
        if (!this.bases.matches(pattern)) {
            this.errorsBase = "*Illegal Number of Sides";
            this.errorsCount++;
        } else if (this.bases == null || this.bases.isEmpty()) {
            this.errorsBase = "*Please enter a value";
            this.errorsCount++;
        } else if (Integer.parseInt(this.bases) < 3) {
            this.errorsBase = "*Number of Base Sides cannot be less than 3";
            this.errorsCount++;
        } else if (Integer.parseInt(this.bases) > 20) {
            this.errorsBase = "*Too many Sides!";
            this.errorsCount++;
        }else {
            this.errorsBase = "";
        }
    }

    private void validateSides() {
        String altPattern = "[1-9]*";
        String pattern = "([1-9]*)\\.([0-9]*)";

        if (this.sides == null || this.sides.isEmpty()) {
            this.errorsSides = "*Please enter a value";
            this.errorsCount++;
        } else if (!this.sides.matches(pattern)) {
            if (!this.sides.matches(altPattern)) {
                this.errorsSides = "*Illegal Side Length";
                this.errorsCount++;
            }
        } else {
            this.errorsSides = "";
        }
    }

    private void validateHeights() {
        String altPattern = "[1-9]*";
        String pattern = "([1-9]*)\\.([0-9]*)";

        if (this.heights == null || this.heights.isEmpty()) {
            this.errorsHeight = "*Please enter a value";
            this.errorsCount++;
        } else if (!this.heights.matches(pattern)) {
            if (!this.heights.matches(altPattern)) {
                this.errorsHeight = "*Illegal Height Value";
                this.errorsCount++;
            }
        } else {
            this.errorsHeight = "";
        }
    }
}
