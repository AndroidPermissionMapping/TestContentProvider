package de.cispa.testcontentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle

class DynamicallyProtectedContentProvider : ContentProvider() {

    companion object {
        const val READ_PERMISSION = "de.cispa.testcontentprovider.permission.READ_SAMPLES"
        const val WRITE_PERMISSION = "de.cispa.testcontentprovider.permission.WRITE_SAMPLES"
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun call(method: String, arg: String?, extras: Bundle?): Bundle? {
        context!!.enforceCallingPermission(WRITE_PERMISSION, "Permission denied.")
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        context!!.enforceCallingPermission(READ_PERMISSION, "Permission denied.")
        return null
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        context!!.enforceCallingPermission(WRITE_PERMISSION, "Permission denied.")
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        context!!.enforceCallingPermission(WRITE_PERMISSION, "Permission denied.")
        return 0
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        context!!.enforceCallingPermission(WRITE_PERMISSION, "Permission denied.")
        return 0
    }
}