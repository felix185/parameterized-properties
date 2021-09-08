package de.riefel.parameterized.weather;

import de.riefel.parameterized.common.property.DoubleProperty;
import de.riefel.parameterized.common.property.IntegerProperty;
import de.riefel.parameterized.common.property.PropertyAttribute;
import de.riefel.parameterized.common.types.AbstractAbsoluteSpreadComparableTO;

/**
 * Transport object representing the weather data.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 07.04.21
 */
public class WeatherTO extends AbstractAbsoluteSpreadComparableTO {

    private static final IntegerProperty DAY_PROPERTY = new IntegerProperty(WeatherTO.class, "Day", 1, 31, PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final IntegerProperty MXT_PROPERTY = new IntegerProperty(WeatherTO.class, "MxT", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final IntegerProperty MNT_PROPERTY = new IntegerProperty(WeatherTO.class, "MnT", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final IntegerProperty AVT_PROPERTY = new IntegerProperty(WeatherTO.class, "AvT", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final DoubleProperty AVDP_PROPERTY = new DoubleProperty(WeatherTO.class, "AvDP", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final IntegerProperty HRP_PROPERTY = new IntegerProperty(WeatherTO.class, "1HrP TPcpn", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final IntegerProperty PDIR_PROPERTY = new IntegerProperty(WeatherTO.class, "PDir", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final DoubleProperty AVSP_PROPERTY = new DoubleProperty(WeatherTO.class, "AvSp", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final IntegerProperty DIR_PROPERTY = new IntegerProperty(WeatherTO.class, "Dir", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final IntegerProperty MXS_PROPERTY = new IntegerProperty(WeatherTO.class, "MxS", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final DoubleProperty SKYC_PROPERTY = new DoubleProperty(WeatherTO.class, "SkyC", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final IntegerProperty MXR_PROPERTY = new IntegerProperty(WeatherTO.class, "MxR", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final IntegerProperty MN_PROPERTY = new IntegerProperty(WeatherTO.class, "Mn", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);
    private static final DoubleProperty RAVSLP_PROPERTY = new DoubleProperty(WeatherTO.class, "R AvSLP", PropertyAttribute.IMMUTABLE, PropertyAttribute.NOT_NULLABLE);


    public WeatherTO(final int day, final int mxt, final int mnt, final int avt, final double avdp, final int hrp,
                     final int pdir, final double avsp, final int dir, final int mxs, final double skyc, final int mxr,
                     final int mn, final double ravslp) {
        super(mxt, mnt);
        setValue(DAY_PROPERTY, day);
        setValue(MXT_PROPERTY, mxt);
        setValue(MNT_PROPERTY, mnt);
        setValue(AVT_PROPERTY, avt);
        setValue(AVDP_PROPERTY, avdp);
        setValue(HRP_PROPERTY, hrp);
        setValue(PDIR_PROPERTY, pdir);
        setValue(AVSP_PROPERTY, avsp);
        setValue(DIR_PROPERTY, dir);
        setValue(MXS_PROPERTY, mxs);
        setValue(SKYC_PROPERTY, skyc);
        setValue(MXR_PROPERTY, mxr);
        setValue(MN_PROPERTY, mn);
        setValue(RAVSLP_PROPERTY, ravslp);
    }

    public int getDay() {
        return getValue(DAY_PROPERTY);
    }

    public int getMxT() {
        return getValue(MXT_PROPERTY);
    }

    public int getMnT() {
        return getValue(MNT_PROPERTY);
    }

    public int getAvT() {
        return getValue(AVT_PROPERTY);
    }

    public double getAvDP() {
        return getValue(AVDP_PROPERTY);
    }

    public int get1HrPTPcpn() {
        return getValue(HRP_PROPERTY);
    }

    public int getPDir() {
        return getValue(PDIR_PROPERTY);
    }

    public double getAvSp() {
        return getValue(AVSP_PROPERTY);
    }

    public int getDir() {
        return getValue(DIR_PROPERTY);
    }

    public int getMxS() {
        return getValue(MXS_PROPERTY);
    }

    public double getSkyC() {
        return getValue(SKYC_PROPERTY);
    }

    public int getMxR() {
        return getValue(MXR_PROPERTY);
    }

    public int getMn() {
        return getValue(MN_PROPERTY);
    }

    public double getRAvSLP() {
        return getValue(RAVSLP_PROPERTY);
    }

    @Override
    public String toString() {
        return "WeatherTO {" +
                "day=" + this.getDay() +
                ", MxT=" + this.getMxT() +
                ", MnT=" + this.getMnT() +
                ", AvT=" + this.getAvT() +
                ", AvDP=" + this.getAvDP() +
                ", 1HrP TPcpn=" + this.get1HrPTPcpn() +
                ", PDir=" + this.getPDir() +
                ", AvSp=" + this.getAvSp() +
                ", Dir=" + this.getDir() +
                ", MxS=" + this.getMxS() +
                ", SkyC=" + this.getSkyC() +
                ", MxR=" + this.getMxR() +
                ", Mn=" + this.getMn() +
                ", R AvSLP=" + this.getRAvSLP() +
                "}";
    }
}
