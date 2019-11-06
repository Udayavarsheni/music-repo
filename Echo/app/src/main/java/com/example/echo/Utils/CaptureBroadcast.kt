package com.example.echo.Utils

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.telephony.TelephonyManager
import com.example.echo.Activities.MainActivity
import com.example.echo.Fragment.SongPlayingFragment
import com.example.echo.R


internal class CaptureBroadcast : BroadcastReceiver() {


        object Statified {
            var incomingFlag = false
            // var incoming_number: String? = null
        }

        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == Intent.ACTION_NEW_OUTGOING_CALL) {

                Statified.incomingFlag = false
                try {
                    MainActivity.statified.notificationManager?.cancel(1997)

                    if (SongPlayingFragment.Statified.mediaPlayer?.isPlaying as Boolean) {
                        (SongPlayingFragment.Statified.mediaPlayer as MediaPlayer).pause()
                        (SongPlayingFragment.Statified.playpauseImageButton)?.setBackgroundResource(R.drawable.play_icon)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            } else {
                val tm: TelephonyManager = context.getSystemService(Service.TELEPHONY_SERVICE) as TelephonyManager

                when (tm.callState) {

                    TelephonyManager.CALL_STATE_RINGING -> {
                        Statified.incomingFlag = true
                        //  CaptureBroadcast.Statified.incoming_number = intent.getStringExtra("incoming_number")
                        try {
                            if (SongPlayingFragment.Statified.mediaPlayer?.isPlaying as Boolean) {
                                (SongPlayingFragment.Statified.mediaPlayer as MediaPlayer).pause()
                                    (SongPlayingFragment.Statified.playpauseImageButton)?.setBackgroundResource(R.drawable.play_icon)

                                MainActivity.statified.notificationManager?.cancel(1997)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    else -> {
                    }
                }

            }

        }
    }



