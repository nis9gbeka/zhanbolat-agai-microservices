package bex.ordersservice.models;

import java.util.List;

public class UserOrderr {
    private List<Orderr> userOrderr;

    public List<Orderr> getUserOrderr() {
        return userOrderr;
    }

    public void setUserOrderr(List<Orderr> userOrderr) {
        this.userOrderr = userOrderr;
    }
}
