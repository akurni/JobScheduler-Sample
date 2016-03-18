package com.appsindotech.jobschedulersample.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import com.appsindotech.jobschedulersample.MainActivity;

import java.util.LinkedList;

/**
 * JobService to be scheduled by the JobScheduler. Requests scheduled with
 * the JobScheduler ultimately land on this service's "onStartJob" method.
 * Currently the service only write log entry
 */

public class TestJobService extends JobService {
  private static final String TAG = "HardWorkService";


  @Override
  public boolean onStartJob(JobParameters params) {
    // We don't do any real 'work' in this sample app. All we'll
    // do is track which jobs have landed on our service, and
    // update the UI accordingly.
    Log.i(TAG, "on start job: " + params.getJobId());
    return true;
  }

  @Override
  public boolean onStopJob(JobParameters params) {
    Log.i(TAG, "on stop job: " + params.getJobId());
    return true;
  }

  MainActivity mActivity;
  private final LinkedList<JobParameters> jobParamsMap = new LinkedList<JobParameters>();

  public void setUiCallback(MainActivity activity) {
    mActivity = activity;
  }

} 