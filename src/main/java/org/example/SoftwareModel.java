package org.example;

public class SoftwareModel {
    private MongoService mongoService;

    public SoftwareModel() {
        mongoService = new MongoService();
    }

    public void add(String id, String name, String age, String city) {
        mongoService.add(id, name, age, city);
    }

    public void delete(String id) {
        mongoService.delete(id);
    }

    public void update(String id, String name, String age, String city) {
        mongoService.update(id, name, age, city);
    }

    public String read(String id) {
       return mongoService.read(id);
    }
}
