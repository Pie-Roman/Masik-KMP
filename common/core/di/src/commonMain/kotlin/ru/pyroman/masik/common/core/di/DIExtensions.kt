package ru.pyroman.news.common.core.di

import org.kodein.di.DI
import org.kodein.di.DirectDIAware
import org.kodein.di.bind
import org.kodein.di.bindings.BindingDI
import org.kodein.di.bindings.NoArgBindingDI
import org.kodein.di.bindings.RefMaker
import org.kodein.di.factory
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

inline fun <reified T> DirectDIAware.lazyInstance(): Lazy<T> = lazy { instance() }

inline fun module(
    name: String,
    noinline init: DI.Builder.() -> Unit,
) = module(name, false, "", init)

inline fun module(
    name: String,
    allowSilentOverride: Boolean,
    prefix: String,
    noinline init: DI.Builder.() -> Unit,
) = DI.Module(name, allowSilentOverride, prefix, init)

fun DI.Builder.importAll(
    modules: List<DI.Module>,
) = importAll(modules)

inline fun DirectDIAware.taggedInstance(
    tag: Any?,
) = instance<Any>(tag)

inline fun DI.Builder.taggedProvider(
    tag: Any?,
    noinline creator: NoArgBindingDI<Any>.() -> Any,
) = provider(tag, null, creator)

inline fun <reified  T : Any> DI.Builder.provider(
    noinline creator: NoArgBindingDI<Any>.() -> T,
) = provider(null, null, creator)

inline fun <reified T : Any> DI.Builder.provider(
    tag: Any? = null,
    overrides: Boolean? = null,
    noinline creator: NoArgBindingDI<Any>.() -> T,
) = bind<T>(tag, overrides) with provider(creator)

inline fun DI.Builder.taggedSingleton(
    tag: Any?,
    noinline creator: NoArgBindingDI<Any>.() -> Any,
) = singleton(tag, null, null, true, creator)

inline fun <reified T : Any> DI.Builder.singleton(
    noinline creator: NoArgBindingDI<Any>.() -> T,
) = singleton(null, null, null, true, creator)

inline fun <reified T : Any> DI.Builder.singleton(
    tag: Any?,
    overrides: Boolean? = null,
    ref: RefMaker? = null,
    sync: Boolean = true,
    noinline creator: NoArgBindingDI<Any>.() -> T,
) = bind<T>(tag, overrides) with singleton(ref, sync, creator)

inline fun <reified A : Any, reified T : Any> DI.Builder.factory(
    tag: Any? = null,
    overrides: Boolean? = null,
    noinline creator: BindingDI<Any>.(A) -> T,
) = bind<T>(tag, overrides) with factory(creator)

