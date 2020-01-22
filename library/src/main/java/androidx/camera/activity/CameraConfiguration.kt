package androidx.camera.activity

private const val LIB = BuildConfig.LIBRARY_PACKAGE_NAME

object CameraConfiguration {

    /** Result key for the captured image URI */
    const val IMAGE_URI = "$LIB.IMAGE_URI"

    /** User configuration key for viewfinder overlay resource ID */
    const val VIEW_FINDER_OVERLAY = "$LIB.VIEW_FINDER_OVERLAY"

    /** User configuration key for default camera lens facing */
    const val CAMERA_LENS_FACING = "$LIB.CAMERA_LENS_FACING"

    /** User configuration key for camera switching behavior */
    const val FULL_SCREEN_ENABLED = "$LIB.FULL_SCREEN_ENABLED"

    /** User configuration key for camera switching behavior */
    const val CAMERA_SWITCH_DISABLED = "$LIB.CAMERA_SWITCH_DISABLED"
}
