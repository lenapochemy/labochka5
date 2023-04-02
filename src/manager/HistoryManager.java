package manager;

import main.Main;
public class HistoryManager {
    private String[] history;

    public HistoryManager(){
        this.history = new String[Main.NUMBER_OF_CMD];
    }

    public String[] getHistory(){
        return history;
    }

    public void addToHistory(String newCommand){
        for(int i = 0; i < Main.NUMBER_OF_CMD - 1; i++){
            history[i] = history[i+1];
        }
        history[Main.NUMBER_OF_CMD -1] = newCommand;
    }
}
