
#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jint JNICALL
Java_com_salam_ndktasktest_MainActivity_sumOfNumbers(JNIEnv *env, jobject instance, jint a,
                                                     jint b) {
    return (a + b);
}//
// Created by Muhammad on 2019-10-18.
//

