import java.util.ArrayList;

//======================================================================================================================
public class LightStrip {
//----------------------------------------------------------------------------------------------------------------------
    private ArrayList<Light> lightstrip;
    private double totalLumens;
    private int fluorescent;
    private double heatOutput;
    private int index;
//----------------------------------------------------------------------------------------------------------------------
    public LightStrip() {

        lightstrip = new ArrayList<>();

        totalLumens = 0.0;
        fluorescent = 0;
        heatOutput = 0.0;
    }
//----------------------------------------------------------------------------------------------------------------------
    public void display() {

        for (index = 0; index < lightstrip.size(); index++) {
            System.out.println(index + ": " + lightstrip.get(index));
        }
        System.out.println("Total lumens = " + totalLumens);
        System.out.println("Fluorescent = " + fluorescent);
        System.out.println("Heat output = " + heatOutput);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void addLight(Light lights) {

        if (lights instanceof Fluorescent) {
            fluorescent++;
        }
        else if (lights instanceof Incandescent) {
            heatOutput = heatOutput + lights.heatOutput();
        }
        totalLumens += lights.getLumens();
        lightstrip.add(lights);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void removeLight(int index) {

        try {
            if (lightstrip.get(index) instanceof Fluorescent) {
                fluorescent--;
            } else if (lightstrip.get(index) instanceof Incandescent) {
                heatOutput = heatOutput - ((Incandescent) lightstrip.get(index)).heatOutput();
            }
            totalLumens -= ((Light) lightstrip.get(index)).getLumens();
            lightstrip.remove(index);
        }
        catch (Exception e) {
            System.out.println("ERROR: No light at that index ");
        }
    }
//----------------------------------------------------------------------------------------------------------------------
}
//======================================================================================================================
