package org.example;

public class GoodsBogie {

    private String type;
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    // UC15
    public void assignCargo(String cargo) {

        try {
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Petroleum not allowed in Rectangular bogie"
                );
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            System.out.println("Assignment process completed.\n");
        }
    }
}