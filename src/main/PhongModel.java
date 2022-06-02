package main;

public class PhongModel {

    public static double getLight(Vector observer, Vector normal, LightEmitter lightSource, Material material) {
        Vector observerVector = new Vector(observer.getX() - normal.getX(), observer.getY() - normal.getY(), observer.getZ() - normal.getZ());

        Vector lightSourceVector = lightSource.getVector();
        Vector lightVector = new Vector(lightSourceVector.getX() - normal.getX(), lightSourceVector.getY() - normal.getY(), lightSourceVector.getZ() - normal.getZ());

        Vector lightVectorNormalized = lightVector.normalize();
        Vector normalizedNormal = normal.normalize();

        Vector refNormalized = reflection(lightVectorNormalized, normalizedNormal).normalize();
        Vector observerNormalized = observerVector.normalize();

        return material.getKa() * lightSource.getAmbient() +
                material.getKd() * lightSource.getIllumination() * normalizedNormal.scalarProduct(lightVectorNormalized) +
                material.getKs() * lightSource.getIllumination() * Math.pow(refNormalized.scalarProduct(observerNormalized), material.getN());
    }

    private static Vector reflection(Vector lightVecNormalized, Vector normalNormalized) {
        double product = lightVecNormalized.scalarProduct(normalNormalized);

        double x = 2 * product * normalNormalized.getX() - lightVecNormalized.getX();
        double y = 2 * product * normalNormalized.getY() - lightVecNormalized.getY();
        double z = 2 * product * normalNormalized.getZ() - lightVecNormalized.getZ();

        return new Vector(x, y, z);
    }
}
