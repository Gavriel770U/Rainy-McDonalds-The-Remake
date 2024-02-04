public enum Settings 
{
    FRAME_WIDTH (1000),
    FRAME_HEIGHT(800);

    public final Integer value;

    private Settings(final Integer value)
    {
        this.value = value;
    }
}