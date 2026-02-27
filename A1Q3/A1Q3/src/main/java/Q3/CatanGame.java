package Q3;

public class CatanGame {

    private List<CatanAgent> agents;
    private GameState state;

    public CatanGame(List<CatanAgent> agents) {
        this.agents = agents;
        this.state = new GameState();
    }

    public void playTurn(int currentPlayer) {
        CatanAgent agent = agents.get(currentPlayer);
        Move move = agent.chooseMove(state);
        state.applyMove(currentPlayer, move);
    }
}