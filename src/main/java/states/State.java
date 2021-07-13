package states;

import server.Server;

public abstract class State {
    Server server;

    public State (Server server) {
        this.server = server;
    }

    public abstract void process();

}
