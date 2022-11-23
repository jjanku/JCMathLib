package opencrypto.jcmathlib;

/**
 *
 * @author Petr Svenda
 */
public class BaseHelper {
    final ResourceManager rm;

    public BaseHelper(ResourceManager resman) {
        rm = resman;
    }
    
    /**
     * Lock/reserve provided object for subsequent use. Used to protect
     * corruption of pre-allocated shared objects in different, potentially
     * nested, operations. Must be unlocked later on.
     *
     * @param objToLock array to be locked
     * @throws SW_ALREADYLOCKED if already locked (is already in use by other
     * operation)
     */
    public void lock(byte[] objToLock) {
        rm.locker.lock(objToLock);
    }

    /**
     * Unlock/release object from use. Used to protect corruption of
     * pre-allocated objects used in different nested operations. Must be locked
     * before.
     *
     * @param objToUnlock object to unlock
     * @throws SW_NOTLOCKED_BIGNAT if was not locked before (inconsistence in
     * lock/unlock sequence)
     */
    public void unlock(byte[] objToUnlock) {
        rm.locker.unlock(objToUnlock);
    }

    /**
     * Unlocks all locked objects
     */
    public void unlockAll() {
        rm.locker.unlockAll();
    }

    /**
     * Allocates new byte[] array with provided length either in RAM or EEPROM
     * based on an allocator type. Method updates internal counters of bytes
     * allocated with specific allocator. Use {@code getAllocatedInRAM()} or
     * {@code getAllocatedInEEPROM} for counters readout.
     *
     * @param length length of array
     * @param allocatorType type of allocator
     * @return allocated array
     */
    public byte[] allocateByteArray(short length, byte allocatorType) {
        return rm.memAlloc.allocateByteArray(length, allocatorType);        
    }    
}
