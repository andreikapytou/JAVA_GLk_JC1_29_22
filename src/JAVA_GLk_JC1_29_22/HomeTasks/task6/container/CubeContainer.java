package JAVA_GLk_JC1_29_22.HomeTasks.task6.container;

import JAVA_GLk_JC1_29_22.HomeTasks.task6.Const;

import java.lang.Math;

public class CubeContainer extends AbstractContainer {

    @Override
    public int calculateVolume() {

        return Math.round((float) (Math.sqrt(3) * Math.pow(calculationSizeDiagonal(), 3)) / 9);
    }

    @Override
    public String getTypeGeometry() {

        return Const.TYPE_GEOMETRY_CUBE_CONTAINER;
    }

    public CubeContainer(int typeSize, int densityWater) {

        super(typeSize, densityWater);
    }
}
