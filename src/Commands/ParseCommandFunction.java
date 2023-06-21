package Commands;
@FunctionalInterface
public interface ParseCommandFunction {
	public abstract Command accion(String s);
}
