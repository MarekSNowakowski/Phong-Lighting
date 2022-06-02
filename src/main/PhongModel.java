package main;

public class PhongModel {

    public static double getLight(Vector observer, Vector normal, LightEmitter lightSource, Material material) {
        Vector observerVector = new Vector(observer.getX() - normal.getX(), observer.getY() - normal.getY(), observer.getZ() - normal.getZ());

        Vector lightSourceVector = lightSource.getVector();
        Vector lightVector = new Vector(lightSourceVector.getX() - normal.getX(), lightSourceVector.getY() - normal.getY(), lightSourceVector.getZ() - normal.getZ());

        Vector lightVectorNormalized = lightVector.normalize();
        Vector normalizedNormal = normal.normalize();

        Vector refNorm = reflect(lightVectorNormalized, normalizedNormal).normalize();
        Vector observerNorm = observerVector.normalize();

        return material.getKa() * lightSource.getAmbient() +
                material.getKd() * lightSource.getIllumination() * normalizedNormal.scalarProduct(lightVectorNormalized) +
                material.getKs() * lightSource.getIllumination() * Math.pow(refNorm.scalarProduct(observerNorm), material.getN());
    }

    private static Vector reflect(Vector normal, Vector lightVecNormalized) {
        double product = lightVecNormalized.scalarProduct(normal);

        double x = 2 * product * normal.getX() - lightVecNormalized.getX();
        double y = 2 * product * normal.getY() - lightVecNormalized.getY();
        double z = 2 * product * normal.getZ() - lightVecNormalized.getZ();

        return new Vector(x, y, z);
    }
}
