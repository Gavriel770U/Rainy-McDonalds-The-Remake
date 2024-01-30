public enum Settings 
{
    FRAME_WIDTH (800),
    FRAME_HEIGHT(600),
    WIDTH_GROWTH(8),
    HEIGHT_GROWTH(6);

    public final Integer value;

    private Settings(final Integer value)
    {
        this.value = value;
    }
}