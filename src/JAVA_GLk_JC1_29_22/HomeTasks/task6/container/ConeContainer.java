package JAVA_GLk_JC1_29_22.HomeTasks.task6.container;

import JAVA_GLk_JC1_29_22.HomeTasks.task6.Const;
import java.lang .Math;

public class ConeContainer extends AbstractContainer {

    @Override
    public int calculateVolume() {

        return Math.round((float) (Math.PI * Math.pow(calculationSizeDiagonal(), 2) * getHeight()) /12);
    }

    @Override
    public String getTypeGeometry(){

        return Const.TYPE_GEOMETRY_CONE_CONTAINER;
    }

    public ConeContainer(int typeSize, int height, int densityWater)  {

        super(typeSize, height, densityWater);
    }
}
