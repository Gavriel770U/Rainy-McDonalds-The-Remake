public enum Settings 
{
    FRAME_WIDTH(System.getProperty("os.name").toLowerCase().contains("win") ? 800 : 1000),
    FRAME_HEIGHT(System.getProperty("os.name").toLowerCase().contains("win") ? 600 : 800);

    public final Integer value;

    private Settings(Integer value) 
    {
        this.value = value;
    }
}
