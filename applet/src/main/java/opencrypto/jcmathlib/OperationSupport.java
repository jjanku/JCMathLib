package opencrypto.jcmathlib;

/**
 * OperationSupport class
 *
 * @author Antonin Dufka
 */
public class OperationSupport {
    private static OperationSupport instance;

    public static final short SIMULATOR = 0x0000;
    public static final short J2E145G = 0x0001;
    public static final short J3H145 = 0x0002;
    public static final short J3R180 = 0x0003;

    public boolean RSA_MULT_TRICK = false;
    public boolean RSA_MOD_MULT_TRICK = false;
    public boolean RSA_MOD_EXP = false;
    public boolean RSA_MOD_EXP_EXTRA_MOD = false;
    public boolean RSA_MOD_EXP_PUB = false;
    public boolean RSA_PREPEND_ZEROS = false;
    public boolean RSA_KEY_REFRESH = false;
    public boolean RSA_RESIZE_BASE = true;
    public boolean RSA_RESIZE_MODULUS = true;
    public boolean RSA_RESIZE_MODULUS_APPEND = false;
    public boolean EC_HW_XY = false;
    public boolean EC_HW_X = true;
    public boolean EC_HW_ADD = false;
    public boolean EC_SW_DOUBLE = false;
    public boolean DEFERRED_INITIALIZATION = false;

    private OperationSupport() {
    }

    public static OperationSupport getInstance() {
        if (OperationSupport.instance == null)
            OperationSupport.instance = new OperationSupport();
        return OperationSupport.instance;
    }

    public void setCard(short card_identifier) {
        switch (card_identifier) {
            case SIMULATOR:
                RSA_MULT_TRICK = false;
                RSA_MOD_EXP = true;
                RSA_PREPEND_ZEROS = true;
                RSA_KEY_REFRESH = true;
                RSA_RESIZE_BASE = true;
                RSA_RESIZE_MODULUS = false;
                EC_SW_DOUBLE = true;
                EC_HW_XY = true;
                EC_HW_ADD = true;
                break;
            case J2E145G:
                RSA_MOD_MULT_TRICK = false;
                RSA_MULT_TRICK = true;
                RSA_MOD_EXP = true;
                RSA_MOD_EXP_EXTRA_MOD = true;
                RSA_MOD_EXP_PUB = true;
                RSA_RESIZE_BASE = true;
                RSA_RESIZE_MODULUS = true;
                RSA_RESIZE_MODULUS_APPEND = true;
                EC_HW_X = true;
                break;
            case J3H145:
                DEFERRED_INITIALIZATION = true;
                RSA_MOD_MULT_TRICK = true;
                RSA_MULT_TRICK = true;
                RSA_MOD_EXP = true;
                RSA_MOD_EXP_PUB = true;
                EC_HW_XY = true;
                EC_HW_ADD = true;
                break;
            case J3R180:
                DEFERRED_INITIALIZATION = true;
                RSA_MOD_MULT_TRICK = true;
                RSA_MULT_TRICK = true;
                RSA_MOD_EXP = true;
                EC_HW_XY = true;
                EC_HW_ADD = true;
                break;
            default:
                break;
        }
    }
}
