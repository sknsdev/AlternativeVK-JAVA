package com.vlasov.alternativevk.common.manager;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import com.vlasov.alternativevk.ui.activity.BaseActivity;
import com.vlasov.alternativevk.ui.fragment.BaseFragment;

import java.util.Stack;

public class MyFragmentManager {
    private static final int EMPTY_FRAGMENNT_STACK_SIZE = 1;
    private Stack<BaseFragment> mFragmentStack = new Stack<>();

    private BaseFragment mCurrentFragment;


    public void setFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId){
        if(activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)){
            FragmentTransaction transaction = createAddTransaction(activity, fragment, false);
            transaction.replace(containerId, fragment);
            commitAddTransaction(activity,fragment,transaction,false);
        }
    }



    public void addFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId){//создание фрагментов поверх корневого
        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)){
            FragmentTransaction transaction = createAddTransaction(activity, fragment, true);
            transaction.add(containerId, fragment);
            commitAddTransaction(activity,fragment,transaction,true);
        }
    }

    private FragmentTransaction createAddTransaction(BaseActivity activity, BaseFragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();

        if (addToBackStack){
            fragmentTransaction.addToBackStack((fragment.getTag()));
        }

        return fragmentTransaction;
    }


    private void commitAddTransaction(BaseActivity activity, BaseFragment fragment, FragmentTransaction transaction, boolean addToBackStack){
        if (transaction != null){
            mCurrentFragment = fragment;

            if (!addToBackStack){
                mFragmentStack = new Stack<>();
            }

            mFragmentStack.add(fragment);
            commitTransaction(activity, transaction);
        }
    }

    public boolean removeCurrentFragment(BaseActivity activity){
        return removeFragment(activity, mCurrentFragment);
    }

    public boolean removeFragment(BaseActivity activity, BaseFragment fragment){
        boolean canRemove = fragment != null && mFragmentStack.size() > EMPTY_FRAGMENNT_STACK_SIZE; //Предотвращение удаления корневоого элемента

        if (canRemove){
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

            mFragmentStack.pop();
            mCurrentFragment = mFragmentStack.lastElement();

            transaction.remove(fragment);
            commitTransaction(activity,transaction);
        }

        return canRemove;
    }


    private void commitTransaction(BaseActivity activity, FragmentTransaction transaction){
        transaction.commit();

        activity.fragmentOnScreen(mCurrentFragment);
    }

    public boolean isAlreadyContains(BaseFragment baseFragment){
        if (baseFragment == null){
            return false;
        }
        return mCurrentFragment != null && mCurrentFragment.getClass().getName().equals(baseFragment.getClass().getName());
    }
}
