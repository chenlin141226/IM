package com.jaffa.hardy.im.factory

import android.support.v4.app.Fragment
import com.jaffa.hardy.im.R
import com.jaffa.hardy.im.ui.fragment.ContactFragment
import com.jaffa.hardy.im.ui.fragment.ConversationFragment
import com.jaffa.hardy.im.ui.fragment.DynamicFragment

/**
 * 创建Fragment的工厂类
 */
class FragmentFactory private constructor(){

    val conversation by lazy { ConversationFragment() }

    val contact by lazy { ContactFragment() }

    val dynamic by lazy { DynamicFragment() }

    companion object {
       val instance  = FragmentFactory()
    }


    fun getFragment(tabId : Int) : Fragment?{
        when(tabId){
            R.id.tab_conversation -> return conversation

            R.id.tab_contacts -> return contact

            R.id.tab_dynamic -> return dynamic
        }
        return null
    }
}