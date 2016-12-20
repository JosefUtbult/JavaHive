package Objects;

import Graphic.Renderable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josef on 2016-12-03.
 */
public class RenderableQueue {

    private List<Renderable> queue = new ArrayList<>();

    private static class ObjectKeeperHolder {
        public static final RenderableQueue instance = new RenderableQueue();
    }

    public static RenderableQueue get() {
        return ObjectKeeperHolder.instance;
    }

    private RenderableQueue() {
    }

    public void addObject(Renderable renderable) {
        this.queue.add(renderable);
    }

    public void removeObject(Renderable renderable) {
        this.queue.remove(renderable);
    }

    public void renderQueue(Graphics g) {
        queue.forEach(renderable -> renderable.render(g));
    }

}
