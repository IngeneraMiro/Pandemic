package pandemia.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pandemia.services.UserService;

@Component
public class InitOnStart implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    UserService userService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        userService.initApp();
        System.out.println("App is running !!!");
    }
}
