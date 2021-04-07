package de.riefel.parameterized.weather;

import de.riefel.parameterized.common.validation.ArgumentChecker;
import de.riefel.parameterized.reader.AbstractLineMapper;

import java.util.Map;

/**
 * Maps a line of weather data to actual {@link WeatherTO}. Extends {@link AbstractLineMapper} for utility methods.
 *
 * @author Felix Riess <felix@felix-riess.de>
 * @since 07.04.21
 */
public class WeatherLineMapper extends AbstractLineMapper<WeatherTO> {

    static final String DAY_KEY = "Day";
    static final String MXT_KEY = "MxT";
    static final String MNT_KEY = "MnT";
    static final String AVT_KEY = "AvT";
    static final String AVDP_KEY = "AvDP";
    static final String HRP_KEY = "1HrP TPcpn";
    static final String PDIR_KEY = "PDir";
    static final String AVSP_KEY = "AvSp";
    static final String DIR_KEY = "Dir";
    static final String MXS_KEY = "MxS";
    static final String SKYC_KEY = "SkyC";
    static final String MXR_KEY = "MxR";
    static final String MN_KEY = "Mn";
    static final String RAVSLP_KEY = "R AvSLP";

    @Override
    public WeatherTO mapToTO(final Map<String, String> toBeMapped) {
        ArgumentChecker.checkInterval(14, toBeMapped.size(), 15, "Line Length");
        final int day = getIntPropertyOrFail(toBeMapped, DAY_KEY);
        final int mxt = getIntPropertyOrFail(toBeMapped, MXT_KEY);
        final int mnt = getIntPropertyOrFail(toBeMapped, MNT_KEY);
        final int avt = getIntPropertyOrFail(toBeMapped, AVT_KEY);
        final double avdp = getDoublePropertyOrFail(toBeMapped, AVDP_KEY);
        final int hrp = getIntPropertyOrFail(toBeMapped, HRP_KEY);
        final int pdir = getIntPropertyOrFail(toBeMapped, PDIR_KEY);
        final double avsp = getDoublePropertyOrFail(toBeMapped, AVSP_KEY);
        final int dir = getIntPropertyOrFail(toBeMapped, DIR_KEY);
        final int mxs = getIntPropertyOrFail(toBeMapped, MXS_KEY);
        final double skyc = getDoublePropertyOrFail(toBeMapped, SKYC_KEY);
        final int mxr = getIntPropertyOrFail(toBeMapped, MXR_KEY);
        final int mn = getIntPropertyOrFail(toBeMapped, MN_KEY);
        final double ravslp = getDoublePropertyOrFail(toBeMapped, RAVSLP_KEY);

        return new WeatherTO(day, mxt, mnt, avt, avdp, hrp, pdir, avsp, dir, mxs, skyc, mxr, mn, ravslp);
    }
}
