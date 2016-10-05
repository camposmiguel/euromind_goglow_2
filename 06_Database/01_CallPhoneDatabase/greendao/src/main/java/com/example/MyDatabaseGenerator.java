package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyDatabaseGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.miguelcr.callphonedatabase.db");

        createCallPhoneDatabase(schema);

        new DaoGenerator().generateAll(schema,
                "../01_CallPhoneDatabase/app/src/main/java");
    }

    private static void createCallPhoneDatabase(Schema schema) {
        Entity callPhones = schema.addEntity("CallPhone");
        callPhones.addIdProperty().autoincrement().primaryKey();
        callPhones.addStringProperty("contactName");
        callPhones.addStringProperty("time");
        callPhones.addIntProperty("callType");
        callPhones.addStringProperty("phoneNumber");
    }

}
