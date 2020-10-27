package net.backdoorinc.bungeesystem;

import lombok.Getter;
import net.backdoorinc.bungeesystem.mysql.MySQL;
import net.backdoorinc.bungeesystem.util.Logger;
import net.backdoorinc.bungeesystem.util.LoggerEnum;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
public class BungeeSystem extends Plugin {

    public BungeeSystem instance;
    public Logger logger = new Logger();
    public MySQL mySQL = null;


    @Override
    public void onEnable() {
        logger.createFile();
        mySQL = new MySQL("","","","");
    }

    @Override
    public void onDisable() {
        mySQL.close();

    }

    @Override
    public void onLoad() {
        try {
            Logger.writeLog(LoggerEnum.LOG, "LOADING ESSENTIAL DATA");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
    protected void createTables() throws IOException {
        try {
            PreparedStatement preparedStatement = mySQL.connection.prepareStatement("CREATE TABLE IF NOT EXISTS Bans(UUID VARCHAR(64),TO TEXT,GRUND VARCHAR(64),BANNER VARCHAR(64)");
            preparedStatement.executeQuery();
        } catch (SQLException exception) {
            Logger.writeLog(LoggerEnum.ERROR, exception.getSQLState() + exception.getMessage());

        }
    }
}
